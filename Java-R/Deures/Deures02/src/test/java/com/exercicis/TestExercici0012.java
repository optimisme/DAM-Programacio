package com.exercicis;

import com.testStringUtils.TestStringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.*;

class TestExercici0012 {

    @Test
    public void testCreateWonder() {
        HashMap<String, Object> wonder = Exercici0012.createWonder("Test Wonder", "Test Location", 1000);
        
        assertEquals("Test Wonder", wonder.get("name"));
        assertEquals("Test Location", wonder.get("location"));
        assertEquals(1000, wonder.get("age"));
    }

    @Test
    public void testSortWondersByName() {
        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(Exercici0012.createWonder("C Wonder", "Location C", 100));
        wonders.add(Exercici0012.createWonder("A Wonder", "Location A", 200));
        wonders.add(Exercici0012.createWonder("B Wonder", "Location B", 300));

        ArrayList<HashMap<String, Object>> sorted = Exercici0012.sortWondersByName(wonders);
        
        ArrayList<String> names = new ArrayList<>();
        for (HashMap<String, Object> wonder : sorted) {
            names.add((String) wonder.get("name"));
        }

        List<String> expected = Arrays.asList("A Wonder", "B Wonder", "C Wonder");
        
        String diff = TestStringUtils.findFirstDifference(names.toString(), expected.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testGetSortedWondersByName() {
        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(Exercici0012.createWonder("C Wonder", "Location C", 100));
        wonders.add(Exercici0012.createWonder("A Wonder", "Location A", 200));
        wonders.add(Exercici0012.createWonder("B Wonder", "Location B", 300));

        ArrayList<HashMap<String, Object>> result = Exercici0012.getSortedWondersByName(wonders, 2);
        assertEquals(2, result.size());
        
        ArrayList<String> names = new ArrayList<>();
        for (HashMap<String, Object> wonder : result) {
            names.add((String) wonder.get("name"));
        }

        List<String> expected = Arrays.asList("A Wonder", "B Wonder");
        
        String diff = TestStringUtils.findFirstDifference(names.toString(), expected.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testSortNames() {
        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(Exercici0012.createWonder("C Wonder", "Location C", 100));
        wonders.add(Exercici0012.createWonder("A Wonder", "Location A", 200));
        wonders.add(Exercici0012.createWonder("B Wonder", "Location B", 300));

        ArrayList<String> result = Exercici0012.sortNames(wonders);
        List<String> expected = Arrays.asList("A Wonder", "B Wonder", "C Wonder");
        
        String diff = TestStringUtils.findFirstDifference(result.toString(), expected.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testGetOlder() {
        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(Exercici0012.createWonder("Wonder 1", "Location 1", 100));
        wonders.add(Exercici0012.createWonder("Wonder 2", "Location 2", 300));
        wonders.add(Exercici0012.createWonder("Wonder 3", "Location 3", 200));

        ArrayList<HashMap<String, Object>> result = Exercici0012.getOlder(wonders, 2);
        assertEquals(2, result.size());
        assertEquals(300, result.get(0).get("age"));
        assertEquals(200, result.get(1).get("age"));
    }

    @Test
    public void testGetRegion() {
        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(Exercici0012.createWonder("Wonder 1", "Turkey Location", 100));
        wonders.add(Exercici0012.createWonder("Wonder 2", "Greece Location", 200));
        wonders.add(Exercici0012.createWonder("Wonder 3", "Another Turkey Place", 300));

        ArrayList<HashMap<String, Object>> result = Exercici0012.getRegion(wonders, "Turkey");
        assertEquals(2, result.size());
        assertTrue(((String) result.get(0).get("location")).contains("Turkey"));
        assertTrue(((String) result.get(1).get("location")).contains("Turkey"));
    }

    @Test
    public void testMainFunction() throws Exception {
        String text = SystemLambda.tapSystemOut(() -> {
            Exercici0012.main(new String[]{});
        });

        String expectedOutput = """
            All Wonders:
            * Name: Great Pyramid of Giza
              Location: Egypt
              Age: 4500 years
            * Name: Hanging Gardens of Babylon
              Location: Babylon, Mesopotamia
              Age: 2500 years
            * Name: Statue of Zeus at Olympia
              Location: Olympia, Greece
              Age: 2500 years
            * Name: Temple of Artemis at Ephesus
              Location: Ephesus, Turkey
              Age: 2400 years
            * Name: Mausoleum at Halicarnassus
              Location: Halicarnassus, Turkey
              Age: 2300 years
            * Name: Colossus of Rhodes
              Location: Island of Rhodes, Greece
              Age: 2300 years
            * Name: Lighthouse of Alexandria
              Location: Alexandria, Egypt
              Age: 2200 years
            -------------------------
            Sorted Names:
            [Colossus of Rhodes, Great Pyramid of Giza, Hanging Gardens of Babylon, Lighthouse of Alexandria, Mausoleum at Halicarnassus, Statue of Zeus at Olympia, Temple of Artemis at Ephesus]
            -------------------------
            Top 3 Oldest Wonders:
            * Name: Great Pyramid of Giza
              Location: Egypt
              Age: 4500 years
            * Name: Hanging Gardens of Babylon
              Location: Babylon, Mesopotamia
              Age: 2500 years
            * Name: Statue of Zeus at Olympia
              Location: Olympia, Greece
              Age: 2500 years
            -------------------------
            Wonders in Turkey:
            * Name: Temple of Artemis at Ephesus
              Location: Ephesus, Turkey
              Age: 2400 years
            * Name: Mausoleum at Halicarnassus
              Location: Halicarnassus, Turkey
              Age: 2300 years
            """.replace("\r\n", "\n");

        text = text.replace("\r\n", "\n");
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }
}