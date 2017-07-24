package atm;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class TransactionController {

    
    @Autowired
    private ATMRepository atmRepository;
    
   
    @Autowired
    private AccountRepository accountRepository;

    private static String account;
    private static final NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        account = principal.getName();
        String name = accountRepository.findNameByAccount(account);
        model.addAttribute("name", name);
        model.addAttribute("account", account);
        model.addAttribute("balance", usFormat.format(atmRepository.sumByAccID(account)));
        model.addAttribute("message", "Welcome to SpringBank");
        return "Index";
    }

    @RequestMapping("/deposit")
    public String loadDeposit(Model model) {
        model.addAttribute(new Transaction());
        model.addAttribute("page", "deposit");
        model.addAttribute("account", account);
        return "Deposit";
    }

    @RequestMapping("/withdraw")
    public String loadWithdraw(Model model) {
        model.addAttribute(new Transaction());
        model.addAttribute("page", "withdraw");
        model.addAttribute("account", account);
        return "Withdraw";
    }

    @RequestMapping("/depositSubmit")
    public String deposit(@Valid Transaction transaction, BindingResult bindingResult, Model model) {
        model.addAttribute("account", account);
        if (bindingResult.hasErrors()) {
            model.addAttribute("temp", transaction);
            return "Deposit";
        }
        transaction.setAccID(account);
        String name = accountRepository.findNameByAccount(account);
        model.addAttribute("transaction",transaction);
        atmRepository.save(transaction);
        model.addAttribute("name", name);
        model.addAttribute("balance", usFormat.format(atmRepository.sumByAccID(account)));
        model.addAttribute("message", "Deposited " + usFormat.format(transaction.getAmt()));
        return "Index";
    }

    @PostMapping("/withdrawSubmit")
    public String withdraw(@Valid Transaction transaction, BindingResult bindingResult, Model model) {
        model.addAttribute("account", account);
        if (bindingResult.hasErrors()) {
            model.addAttribute("temp", transaction);
            return "Withdraw";
        }
        model.addAttribute("message", "Withdrew " + usFormat.format(transaction.getAmt()));
        transaction.setNegAmt();
        transaction.setAccID(account);
        String name = accountRepository.findNameByAccount(account);
        model.addAttribute("transaction",transaction);
        atmRepository.save(transaction);
        model.addAttribute("name", name);
        model.addAttribute("balance", usFormat.format(atmRepository.sumByAccID(account)));
        return "Index";
    }

    @RequestMapping("/history")
    public String transactionHistory(Model model) {
        model.addAttribute("page", "history");
        model.addAttribute("account", account);
        model.addAttribute("transactionList",atmRepository.findAllByAccID(account));
        model.addAttribute("balance", usFormat.format(atmRepository.sumByAccID(account)));
        return "TransactionHistory";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

