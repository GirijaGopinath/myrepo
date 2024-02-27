package com.precourse;

// import java.util.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;


@Controller
public class MessageController {
     List<MessageItem> messageListItems = new ArrayList<MessageItem>();

        @GetMapping({"/", "/message"})
        public String message(@RequestParam(value ="txtMsg", defaultValue ="", required = true) String txtMessage, Model model)
        {

          // String viewName = "message";
         //  Map<String, Object> mdl = new HashMap<String, Object>();

            messageListItems.clear();
            messageListItems.add(new MessageItem("Logic will get you from A to B. Imagination will take you everywhere."));
             messageListItems.add(new MessageItem("There are two ways of constructing a software design. One way is to make it so simple that there are obviously no deficiencies and the other is to make it so complicated that there are no obvious deficiencies."));
            messageListItems.add(new MessageItem("It's not that I'm so smart, it's just that I stay with problems longer."));
            messageListItems.add(new MessageItem("It is pitch dark. You are likely to be eaten by a grue."));

            Random random = new Random();
            int index = random.nextInt(messageListItems.size());
           System.out.println(messageListItems.get(index));
           model.addAttribute("txtMessage", messageListItems.get(index).getMsg());
          //model.put("numberOfItems", messageListItems.size());
           System.out.println("Message is" + messageListItems.get(index).getMsg());

           return "index";
       }

    }
