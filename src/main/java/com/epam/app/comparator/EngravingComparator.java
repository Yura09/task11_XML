package com.epam.app.comparator;

import com.epam.app.model.Gem;

import java.util.Comparator;

public class EngravingComparator implements Comparator<Gem> {
    @Override
    public int compare(Gem o1, Gem o2) {
        return o1.getVisual().getEngraving() - o2.getVisual().getEngraving();
    }
}
