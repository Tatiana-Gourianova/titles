package com.gourianova.reformatting.task;


import com.gourianova.reformatting.model.TitleUnit;

import java.util.ArrayList;

//@Slf4j
public class EnglishTitlesToSrtFormat {
    private String result = null;

    public String getResult() {
        return result;
    }

    public EnglishTitlesToSrtFormat(String titles) {

        ArrayList<String> times = new ArrayList<>();
        ArrayList<String> timesIn = new ArrayList<>();
        ArrayList<String> timesOut = new ArrayList<>();
        ArrayList<String> subtitles = new ArrayList<>();

        StringBuilder subtitlesFinal = new StringBuilder();
        String[] lines = titles.split("\r?\n");

        for (String line : lines) {
            String[] tmp = new String[2];
            if (line != "") {
                tmp = line.split("\t\t");
                if (tmp.length == 2) {
                    times.add(tmp[0]);
                    subtitles.add(tmp[1]);
                }
            }
        }

        String[] tmp = new String[2];
        for (int i = 0; i < times.size(); i++) {

            if (times.get(i) != "") {
                tmp = times.get(i).split(",");
                if (tmp.length >= 1) {
                    timesIn.add(tmp[0]);

                    if (tmp.length >= 1) {
                        timesOut.add(tmp[1]);
                    }
                }

            }
        }

      //  log.info(timesIn.size() + " " + timesIn);
      //  log.info(timesOut.size() + " " + timesOut);


        ArrayList<TitleUnit> subtitlesResult = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < timesIn.size(); i++) {

            String resultString = "";
            String tmpStr = subtitles.get(i);

            if (tmpStr.length() <= 32) resultString = tmpStr;
            else {

                while (tmpStr.length() > 32) {
                    String part = tmpStr.substring(0, 32);
                    int space_devider = part.lastIndexOf(' ');
                    part = part.substring(0, space_devider);

                    space_devider = part.lastIndexOf(' ');

                    if ((part.length() - space_devider) <= 4) {
                        part = part.substring(0, space_devider);
                        System.out.println("SMALL PART" + part);
                    }

                    resultString += part + '\n';
                    tmpStr = tmpStr.replace(part, "");
                    if (tmpStr.indexOf(' ') == 0) tmpStr = tmpStr.substring(1);//если вначале пробед - удалить

                }

                resultString += tmpStr;
            }
            //добавляем остаток строки от целочисленного деления на 32

            TitleUnit unit = new TitleUnit();
            unit.setId(count++);
            unit.setTimePeriod((timesIn.get(i).replace(".", ",") + " --> " + "0" + timesOut.get(i).replace(".", ",")));
            unit.setTitlesItem(resultString);
            subtitlesResult.add(unit);
        }

        for (TitleUnit unit : subtitlesResult) {

            subtitlesFinal.append(unit.getId() + "\n" + unit.getTimePeriod() + "\n" + unit.getTitlesItem() + "\n\n");
        }


        this.result = subtitlesFinal.toString();
    }


}

