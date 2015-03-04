package com.epam.poker;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.epam.poker.Card;
import com.epam.poker.enums.KindCard;
import com.epam.poker.enums.SuitCard;
import com.epam.poker.parser.CodeListParser;
import com.google.common.collect.ImmutableList;

@RunWith(Parameterized.class)
public class TransformParameterizedTest {
    private List<String> testData;
    private List<Card> expected;

    public TransformParameterizedTest(List<String> testData, List<Card> expected) {
        this.testData = testData;
        this.expected = expected;
    }
    
    @Test
    public void getCardTest() {
        List<Card> actual = CodeListParser.parse(testData);
        Assert.assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> transform() {

        List<String> codeList = new ImmutableList.Builder<String>()
                .add("5D", "8C", "9S", "JS", "AC")
                .build();

        List<Card> cardList = new ImmutableList.Builder<Card>()
            .add(new Card(KindCard.FIVE, SuitCard.DIAMONDS))
            .add(new Card(KindCard.EIGHT, SuitCard.CLUBS))
            .add(new Card(KindCard.NINE, SuitCard.SPADES))
            .add(new Card(KindCard.JACK, SuitCard.SPADES))
            .add(new Card(KindCard.ACE, SuitCard.CLUBS))
            .build();

        List<Object[]> parameters = new ArrayList<Object[]>();
        parameters.add(new Object[] {codeList, cardList});
        return parameters;
    }
}
