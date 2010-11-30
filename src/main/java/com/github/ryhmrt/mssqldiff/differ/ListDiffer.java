package com.github.ryhmrt.mssqldiff.differ;

import java.util.ArrayList;
import java.util.List;

import com.github.ryhmrt.mssqldiff.data.Diff;

public class ListDiffer<DATA, DIFF extends Diff<DATA>, DIFFER extends AbstractDiffer<DATA, DIFF>> {
    public List<DIFF> diff(DIFFER differ, List<DATA> fromList, List<DATA> toList) {
        ArrayList<DIFF> result = new ArrayList<DIFF>();
        for (DATA to : toList) {
            if (fromList.contains(to)) continue;
            DIFF diff = differ.diff(null, to);
            if (diff != null && diff.getType() != Diff.Type.EQUAL) result.add(diff);
        }
        for (DATA to : toList) {
            if (!fromList.contains(to)) continue;
            DIFF diff = differ.diff(fromList.get(fromList.indexOf(to)), to);
            if (diff != null && diff.getType() != Diff.Type.EQUAL) result.add(diff);
        }
        for (DATA from : fromList) {
            if (toList.contains(from)) continue;
            DIFF diff = differ.diff(from, null);
            if (diff != null && diff.getType() != Diff.Type.EQUAL) result.add(diff);
        }
        return result;
    }
}
