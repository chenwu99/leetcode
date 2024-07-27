package huisu;

import java.util.ArrayList;
import java.util.List;

public class LC1593 {

    private int max = 0;

    public int maxUniqueSplit(String s) {
        split(0, s, new ArrayList<>());
        return max;
    }

    public void split(int index, String s, List<String> tmpList) {
        if(index == s.length() && tmpList.size() > max){
            max = tmpList.size();
        } else {
            if (tmpList.size() > max || (tmpList.size() + s.length() - index + 1 ) > max) {
                return;
            }
            for (int i = index; i < s.length(); i ++) {
                String subStr = s.substring(index, i + 1);
                if (tmpList.contains(subStr)) {
                    continue;
                }
                tmpList.add(subStr);
                split(i + 1, s, tmpList);
                String removeStrLength = tmpList.get(tmpList.size() - 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
