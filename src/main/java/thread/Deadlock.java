package thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deadlock {

    private static final Pattern TAG_PATTERN = Pattern.compile("<[^>]+>");
    private static final String SPLIT_POSITION_REGEX = "(?<=[。？！])";
    private static final String SUB_SPLIT_POSITION_CH_REGEX = "，";
    private static final String SUB_SPLIT_POSITION_EN_REGEX = ",";

    public List<String> splitText(String raw, int maxLength) {
        List<String> result = new LinkedList<>();
        if (raw == null || raw.isEmpty()) {
            return result;
        }

        String[] sentences = raw.split(SPLIT_POSITION_REGEX);
        for (String sentence : sentences) {
            if (sentence.isEmpty()) {
                continue;
            }

            int nonTagLength = getNonTagLength(sentence);
            if (nonTagLength <= maxLength) {
                result.add(sentence);
                continue;
            }

            int cutPosition = findCutPosition(sentence, maxLength);
            if (cutPosition < 0) {
                result.add(sentence.substring(0, maxLength));
                result.addAll(splitText(sentence.substring(maxLength), maxLength));
            } else {
                result.add(sentence.substring(0, cutPosition));
                result.addAll(splitText(sentence.substring(cutPosition), maxLength));
            }
        }
        return result;
    }

    private int findCutPosition(String text, int maxLength) {
        Matcher matcher = TAG_PATTERN.matcher(text);
        int cutPosition = -1;
        int count = 0;
        int lastTagEnd = 0;

        while (matcher.find()) {
            String nonTagText = text.substring(lastTagEnd, matcher.start());
            for (char c : nonTagText.toCharArray()) {
                if (count == maxLength) {
                    return cutPosition;
                }
                if (c == '，' || c == ',') {
                    cutPosition = count;
                }
                count++;
            }
            lastTagEnd = matcher.end();
        }

        String nonTagText = text.substring(lastTagEnd);
        for (char c : nonTagText.toCharArray()) {
            if (count == maxLength) {
                return cutPosition;
            }
            if (c == '，' || c == ',') {
                cutPosition = count;
            }
            count++;
        }

        return cutPosition;
    }

    private int getNonTagLength(String text) {
        Matcher matcher = TAG_PATTERN.matcher(text);
        int length = text.length();
        while (matcher.find()) {
            length -= matcher.end() - matcher.start();
        }
        return length;
    }

    public static void main(String[] args) {
        Deadlock splitter = new Deadlock();
        String raw = "剧本内<emphasis>容</emphasis>，交<w>互</w>，<phoneme py=\\\"jiao1\\\">交</phoneme>互。<break time=\\\"0.01\\\"/>";
        List<String> result = splitter.splitText(raw, 10);
        for (String s : result) {
            System.out.println(s);
        }
    }

}
