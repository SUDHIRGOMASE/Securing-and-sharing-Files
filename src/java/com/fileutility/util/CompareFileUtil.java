package com.fileutility.util;

import com.fileutiliy.dto.Compare;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompareFileUtil {

    public static List<Compare> compare(File file1, File file2) {
        List<Compare> comparisonList = new ArrayList<Compare>();
        try {

            BufferedReader fBr = new BufferedReader(new FileReader(file1));
            BufferedReader sBr = new BufferedReader(new FileReader(file2));
            String first = null;
            String second = null;
            while (Objects.nonNull(first = fBr.readLine()) && Objects.nonNull(second = sBr.readLine())) {

                if (first.equals(second)) {
                    comparisonList.add(new Compare(first, second, "green"));

                } else {
                    comparisonList.add(new Compare(first, second, "red"));
                }
            }
            while (Objects.nonNull(first = fBr.readLine())) {
                comparisonList.add(new Compare(first, "", "Red"));
            }
            while (Objects.nonNull(second = sBr.readLine())) {
                comparisonList.add(new Compare("", second, "Red"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comparisonList;

    }

}
