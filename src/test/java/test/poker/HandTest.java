package test.poker;


import org.junit.Test;
import poker.kata.CardHands;
import poker.kata.CardRank;
import poker.kata.Hand;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class HandTest {

    @Test
    public void TestHighCard(){
        Hand h = new Hand("Kc 9s Qs Ad 4d 3d 2s");
        assertThat(h.getScore(), is(equalTo(CardHands.HIGH_CARD)));

        h = new Hand("5c 9s Ks Ad 4d 3d 2s");
        assertThat(h.getScore(), is(equalTo(CardHands.HIGH_CARD)));

        h = new Hand("6c 9s 5s Ac 4d 3d 2s");
        assertThat(h.getScore(), is(equalTo(CardHands.HIGH_CARD)));

        h = new Hand("7c 9s 8s Ad 4d 3d 2s");
        assertThat(h.getScore(), is(equalTo(CardHands.HIGH_CARD)));
    }

    @Test
    public void TestPairKK() {
        Hand h = new Hand("Kc 9s Ks Ad 4d 3d 2s");
        assertThat(h.getScore(), is(equalTo(CardHands.PAIR)));
    }

    @Test
    public void TestPair33() {
        Hand h = new Hand("9s Ks 3d 8d 7s Ad 3s");
        assertThat(h.getScore(), is(equalTo(CardHands.PAIR)));
    }


    @Test
    public void TestPairAA() {
        Hand h = new Hand("3s 7d 8s Ac Ad Kd 6d");
        assertThat(h.getScore(), is(equalTo(CardHands.PAIR)));
    }

    @Test
    public void TestDoubleKK99(){
        Hand h = new Hand("Kc 9s Ks 9d 5s 5d 6d");
        assertThat(h.getScore(), is(equalTo(CardHands.TWO_PAIRS)));
    }

    @Test
    public void TestDouble5533(){
        Hand h = new Hand("3d 4h 5h 3s Ad 5s 6h");
        assertThat(h.getScore(), is(equalTo(CardHands.TWO_PAIRS)));
    }

    @Test
    public void TestDoubleTT99(){
        Hand h = new Hand("Th 9d Td 8c 9h 3d Js");
        assertThat(h.getScore(), is(equalTo(CardHands.TWO_PAIRS)));
    }

    @Test
    public void TestSet444(){
        Hand h = new Hand("3d 4h 4s Ad Kd 9c 4c");
        assertThat(h.getScore(), is(equalTo(CardHands.THREE_OF_A_KIND)));
    }

    @Test
    public void TestSetQQQ(){
        Hand h = new Hand("Qh Ks Ad Qs 9c Qc 4c");
        assertThat(h.getScore(), is(equalTo(CardHands.THREE_OF_A_KIND)));
    }

    @Test
    public void TestSet888(){
        Hand h = new Hand("8d 5d 8c Th 8s 4h Kc");
        assertThat(h.getScore(), is(equalTo(CardHands.THREE_OF_A_KIND)));
    }



    @Test
    public void TestFull(){
        Hand h = new Hand("Kd 2d 3h Kh 2s 7c Ks");
        assertThat(h.getScore(), is(equalTo(CardHands.FULL_HOUSE)));

        h = new Hand("Ad As 3s Ah Ks 7c Kc");
        assertThat(h.getScore(), is(equalTo(CardHands.FULL_HOUSE)));

        h = new Hand("7d 2d 7h 8h 3h 7c 2c");
        assertThat(h.getScore(), is(equalTo(CardHands.FULL_HOUSE)));

        h = new Hand("Kc 9s Ks Kd 9d 3c 6d");
        assertThat(h.getScore(), is(equalTo(CardHands.FULL_HOUSE)));
    }
    
    @Test
    public void TestStraightA5Ordered() {
        Hand h = new Hand("As 2d 3s 4h 5c Kd Qs");
        assertThat(h.getScore(), is(equalTo(CardHands.STRAIGHT)));
    }

    @Test
    public void TestStraightATo5Unordered() {
        Hand h = new Hand("3s Kd 4h As 5c Qs 2d");
        assertThat(h.getScore(), is(equalTo(CardHands.STRAIGHT)));
    }

    @Test
    public void TestStraightGeneralOrdered(){
        Hand h = new Hand("7d 8c 9c Ts Jd 3c Ac");
        assertThat(h.getScore(), is(equalTo(CardHands.STRAIGHT)));
    }

    @Test
    public void TestStraight10ToA(){
        Hand h = new Hand("Kd Ac 6c Td Jd 2c Qc");
        assertThat(h.getScore(), is(equalTo(CardHands.STRAIGHT)));
    }

    @Test
    public void TestStraight10ToANoPair(){
        Hand h = new Hand("Kd Ac 2c Td Jd 2c Qc");
        assertThat(h.getScore(), is(equalTo(CardHands.STRAIGHT)));
    }

    @Test
    public void TestStraight10ToANoSetCardsFromSameCardAsFinalCardOfStraight(){
        Hand h = new Hand("Kd Ac Ad Td Jd Ah Qc");
        assertThat(h.getScore(), is(equalTo(CardHands.STRAIGHT)));
    }
}
