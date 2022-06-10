package com.gourianova.reformatting.controller;

import com.gourianova.reformatting.model.TextIn;
import com.gourianova.reformatting.repo.TextInRepo;
import com.gourianova.reformatting.task.EnglishTitlesToSrtFormat;
import com.gourianova.reformatting.task.FrenchTitlesToSrtFormat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import static com.gourianova.reformatting.model.Language.English;

@Controller
public class AddTextInController {
    private static final String FILE_PATH = "resource.txt";

    private static final AtomicLong counter = new AtomicLong();
    private TextInRepo textInRepo;

    public TextInRepo getTextRepo() {
        return textInRepo;
    }

    public void setTextInRepo(TextInRepo textInRepo) {
        this.textInRepo = textInRepo;
    }


    @RequestMapping(value = "/text-in", method = RequestMethod.GET)

    public ModelAndView text() {


        return new ModelAndView("text-in", "confirmTextIn", new TextIn());
    }

    @RequestMapping(value = "/views/jsp/addTextIn", method = RequestMethod.POST)
    public String addTextIn(@ModelAttribute("SpringWeb") TextIn textIn,
                            ModelMap model) throws URISyntaxException {
        model.addAttribute("language_of_subtitles", textIn.getLanguage_of_subtitles());
        model.addAttribute("text_title", textIn.getText_title());
        model.addAttribute("text_path", textIn.getText_path());

        model.addAttribute("titles", textIn.getTitles());

        textIn.setCreate_time(LocalDate.now());
        //TODO: autoincrement in the database
        textIn.setId(counter.incrementAndGet());
        // textIn.setLanguage(Language.French);
        getTextRepo().save(textIn);
        String titles = "";
        byte[] result = textIn.getTitles();
        for (int i = 0; i < result.length; i++) {
            char c = (char) result[i];
            titles += c;

        }
        System.out.println(textIn.getLanguage_of_subtitles());
        //  System.out.println("!" + titles);
        String resultOut;
        if (textIn.getLanguage_of_subtitles() == English) {
            resultOut = new EnglishTitlesToSrtFormat(titles).getResult();
        } else {
            resultOut = new FrenchTitlesToSrtFormat(titles).getResult();
        }
        //textIn.setText_title(resultOut);
        System.out.println(resultOut);

        return "/views/jsp/in_text.jsp";
    }

    @Bean
    CommandLineRunner commandLineRunner(TextInRepo textInRepo) {
        return args -> {
            setTextInRepo(textInRepo);
        };

    }
}