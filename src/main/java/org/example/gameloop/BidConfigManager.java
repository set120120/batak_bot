package org.example.gameloop;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import org.example.model.BidConfig;

import java.util.ArrayList;
import java.util.List;

public class BidConfigManager {


    private final List<BidConfig> bidConfigs;

    public BidConfigManager() {
        this.bidConfigs = new ArrayList<>();

        var trampCount5_1_1 = new BidConfig();
        trampCount5_1_1.setTrampCount(5);
        trampCount5_1_1.setAverageOfTramps(Range.closed(8.80F, 9.80F));
        trampCount5_1_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 4));
        trampCount5_1_1.setBidCount(0);


        var trampCount5_1_2 = new BidConfig();
        trampCount5_1_2.setTrampCount(5);
        trampCount5_1_2.setAverageOfTramps(Range.closed(8.80F, 9.80F));
        trampCount5_1_2.setPointsFromNonTrampSuit(Range.openClosed(4, 9));
        trampCount5_1_2.setBidCount(5);

        var trampCount5_1_3 = new BidConfig();
        trampCount5_1_3.setTrampCount(5);
        trampCount5_1_3.setAverageOfTramps(Range.closed(8.80F, 9.80F));
        trampCount5_1_3.setPointsFromNonTrampSuit(Range.openClosed(9, 15));
        trampCount5_1_3.setBidCount(6);


        var trampCount5_1_4 = new BidConfig();
        trampCount5_1_4.setTrampCount(5);
        trampCount5_1_4.setAverageOfTramps(Range.closed(8.80F, 9.80F));
        trampCount5_1_4.setPointsFromNonTrampSuit(Range.greaterThan(15));
        trampCount5_1_4.setBidCount(7);


        var trampCount5_2 = new BidConfig();
        trampCount5_2.setTrampCount(5);
        trampCount5_2.setAverageOfTramps(Range.upTo(8.80F, BoundType.OPEN));
        trampCount5_2.setPointsFromNonTrampSuit(Range.all());
        trampCount5_2.setBidCount(0);


        var trampCount5_3_1 = new BidConfig();
        trampCount5_3_1.setTrampCount(5);
        trampCount5_3_1.setAverageOfTramps(Range.greaterThan(9.80F));
        trampCount5_3_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 2));
        trampCount5_3_1.setBidCount(0);

        var trampCount5_3_2 = new BidConfig();
        trampCount5_3_2.setTrampCount(5);
        trampCount5_3_2.setAverageOfTramps(Range.greaterThan(9.80F));
        trampCount5_3_2.setPointsFromNonTrampSuit(Range.openClosed(2, 6));
        trampCount5_3_2.setBidCount(5);

        var trampCount5_3_3 = new BidConfig();
        trampCount5_3_3.setTrampCount(5);
        trampCount5_3_3.setAverageOfTramps(Range.greaterThan(9.80F));
        trampCount5_3_3.setPointsFromNonTrampSuit(Range.openClosed(6, 10));
        trampCount5_3_3.setBidCount(6);

        var trampCount5_3_4 = new BidConfig();
        trampCount5_3_4.setTrampCount(5);
        trampCount5_3_4.setAverageOfTramps(Range.greaterThan(9.80F));
        trampCount5_3_4.setPointsFromNonTrampSuit(Range.greaterThan(10));
        trampCount5_3_4.setBidCount(7);

        var trampCount6_1 = new BidConfig();
        trampCount6_1.setTrampCount(6);
        trampCount6_1.setAverageOfTramps(Range.upTo(7.83F, BoundType.OPEN));
        trampCount6_1.setPointsFromNonTrampSuit(Range.all());
        trampCount6_1.setBidCount(0);

        var trampCount6_2_1 = new BidConfig();
        trampCount6_2_1.setTrampCount(6);
        trampCount6_2_1.setAverageOfTramps(Range.openClosed(7.83F, 8.83F));
        trampCount6_2_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 2));
        trampCount6_2_1.setBidCount(0);

        var trampCount6_2_2 = new BidConfig();
        trampCount6_2_2.setTrampCount(6);
        trampCount6_2_2.setAverageOfTramps(Range.openClosed(7.83F, 8.83F));
        trampCount6_2_2.setPointsFromNonTrampSuit(Range.openClosed(2, 5));
        trampCount6_2_2.setBidCount(5);

        var trampCount6_2_3 = new BidConfig();
        trampCount6_2_3.setTrampCount(6);
        trampCount6_2_3.setAverageOfTramps(Range.openClosed(7.83F, 8.83F));
        trampCount6_2_3.setPointsFromNonTrampSuit(Range.openClosed(5, 9));
        trampCount6_2_3.setBidCount(6);

        var trampCount6_2_4 = new BidConfig();
        trampCount6_2_4.setTrampCount(6);
        trampCount6_2_4.setAverageOfTramps(Range.openClosed(7.83F, 8.83F));
        trampCount6_2_4.setPointsFromNonTrampSuit(Range.openClosed(9, 13));
        trampCount6_2_4.setBidCount(7);

        var trampCount6_2_5 = new BidConfig();
        trampCount6_2_5.setTrampCount(6);
        trampCount6_2_5.setAverageOfTramps(Range.openClosed(7.83F, 8.83F));
        trampCount6_2_5.setPointsFromNonTrampSuit(Range.openClosed(13, 19));
        trampCount6_2_5.setBidCount(8);

        var trampCount6_2_6 = new BidConfig();
        trampCount6_2_6.setTrampCount(6);
        trampCount6_2_6.setAverageOfTramps(Range.openClosed(7.83F, 8.83F));
        trampCount6_2_6.setPointsFromNonTrampSuit(Range.greaterThan(19));
        trampCount6_2_6.setBidCount(9);


        var trampCount6_3_1 = new BidConfig();
        trampCount6_3_1.setTrampCount(6);
        trampCount6_3_1.setAverageOfTramps(Range.openClosed(8.83F, 10.5F));
        trampCount6_3_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 2));
        trampCount6_3_1.setBidCount(5);

        var trampCount6_3_2 = new BidConfig();
        trampCount6_3_2.setTrampCount(6);
        trampCount6_3_2.setAverageOfTramps(Range.openClosed(8.83F, 10.5F));
        trampCount6_3_2.setPointsFromNonTrampSuit(Range.openClosed(2, 6));
        trampCount6_3_2.setBidCount(6);

        var trampCount6_3_3 = new BidConfig();
        trampCount6_3_3.setTrampCount(6);
        trampCount6_3_3.setAverageOfTramps(Range.openClosed(8.83F, 10.5F));
        trampCount6_3_3.setPointsFromNonTrampSuit(Range.openClosed(6, 10));
        trampCount6_3_3.setBidCount(7);

        var trampCount6_3_4 = new BidConfig();
        trampCount6_3_4.setTrampCount(6);
        trampCount6_3_4.setAverageOfTramps(Range.openClosed(8.83F, 10.5F));
        trampCount6_3_4.setPointsFromNonTrampSuit(Range.openClosed(10, 15));
        trampCount6_3_4.setBidCount(8);

        var trampCount6_3_5 = new BidConfig();
        trampCount6_3_5.setTrampCount(6);
        trampCount6_3_5.setAverageOfTramps(Range.openClosed(8.83F, 10.5F));
        trampCount6_3_5.setPointsFromNonTrampSuit(Range.openClosed(15, 19));
        trampCount6_3_5.setBidCount(9);

        var trampCount6_3_6 = new BidConfig();
        trampCount6_3_6.setTrampCount(6);
        trampCount6_3_6.setAverageOfTramps(Range.openClosed(8.83F, 10.5F));
        trampCount6_3_6.setPointsFromNonTrampSuit(Range.greaterThan(19));
        trampCount6_3_6.setBidCount(10);

        var trampCount6_4_1 = new BidConfig();
        trampCount6_4_1.setTrampCount(6);
        trampCount6_4_1.setAverageOfTramps(Range.greaterThan(10.5F));
        trampCount6_4_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 2));
        trampCount6_4_1.setBidCount(6);

        var trampCount6_4_2 = new BidConfig();
        trampCount6_4_2.setTrampCount(6);
        trampCount6_4_2.setAverageOfTramps(Range.greaterThan(10.5F));
        trampCount6_4_2.setPointsFromNonTrampSuit(Range.openClosed(2, 5));
        trampCount6_4_2.setBidCount(7);

        var trampCount6_4_3 = new BidConfig();
        trampCount6_4_3.setTrampCount(6);
        trampCount6_4_3.setAverageOfTramps(Range.greaterThan(10.5F));
        trampCount6_4_3.setPointsFromNonTrampSuit(Range.openClosed(5, 9));
        trampCount6_4_3.setBidCount(8);

        var trampCount6_4_4 = new BidConfig();
        trampCount6_4_4.setTrampCount(6);
        trampCount6_4_4.setAverageOfTramps(Range.greaterThan(10.5F));
        trampCount6_4_4.setPointsFromNonTrampSuit(Range.openClosed(9, 14));
        trampCount6_4_4.setBidCount(9);

        var trampCount6_4_5 = new BidConfig();
        trampCount6_4_5.setTrampCount(6);
        trampCount6_4_5.setAverageOfTramps(Range.greaterThan(10.5F));
        trampCount6_4_5.setPointsFromNonTrampSuit(Range.greaterThan(14));
        trampCount6_4_5.setBidCount(10);

        var trampCount7_1 = new BidConfig();
        trampCount7_1.setTrampCount(7);
        trampCount7_1.setAverageOfTramps(Range.upTo(5.99F, BoundType.OPEN));
        trampCount7_1.setPointsFromNonTrampSuit(Range.all());
        trampCount7_1.setBidCount(0);

        var trampCount7_2_1 = new BidConfig();
        trampCount7_2_1.setTrampCount(7);
        trampCount7_2_1.setAverageOfTramps(Range.openClosed(6.99F, 7.99F));
        trampCount7_2_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 2));
        trampCount7_2_1.setBidCount(0);

        var trampCount7_2_2 = new BidConfig();
        trampCount7_2_2.setTrampCount(7);
        trampCount7_2_2.setAverageOfTramps(Range.openClosed(6.99F, 7.99F));
        trampCount7_2_2.setPointsFromNonTrampSuit(Range.openClosed(2, 4));
        trampCount7_2_2.setBidCount(5);

        var trampCount7_2_3 = new BidConfig();
        trampCount7_2_3.setTrampCount(7);
        trampCount7_2_3.setAverageOfTramps(Range.openClosed(6.99F, 7.99F));
        trampCount7_2_3.setPointsFromNonTrampSuit(Range.openClosed(4, 7));
        trampCount7_2_3.setBidCount(6);

        var trampCount7_2_4 = new BidConfig();
        trampCount7_2_4.setTrampCount(7);
        trampCount7_2_4.setAverageOfTramps(Range.openClosed(6.99F, 7.99F));
        trampCount7_2_4.setPointsFromNonTrampSuit(Range.openClosed(7, 10));
        trampCount7_2_4.setBidCount(7);

        var trampCount7_2_5 = new BidConfig();
        trampCount7_2_5.setTrampCount(7);
        trampCount7_2_5.setAverageOfTramps(Range.openClosed(6.99F, 7.99F));
        trampCount7_2_5.setPointsFromNonTrampSuit(Range.openClosed(10, 13));
        trampCount7_2_5.setBidCount(8);

        var trampCount7_2_6 = new BidConfig();
        trampCount7_2_6.setTrampCount(7);
        trampCount7_2_6.setAverageOfTramps(Range.openClosed(6.99F, 7.99F));
        trampCount7_2_6.setPointsFromNonTrampSuit(Range.greaterThan(13));
        trampCount7_2_6.setBidCount(9);

        var trampCount7_3_1 = new BidConfig();
        trampCount7_3_1.setTrampCount(7);
        trampCount7_3_1.setAverageOfTramps(Range.openClosed(7.99F, 8.99F));
        trampCount7_3_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 2));
        trampCount7_3_1.setBidCount(5);

        var trampCount7_3_2 = new BidConfig();
        trampCount7_3_2.setTrampCount(7);
        trampCount7_3_2.setAverageOfTramps(Range.openClosed(7.99F, 8.99F));
        trampCount7_3_2.setPointsFromNonTrampSuit(Range.openClosed(2, 7));
        trampCount7_3_2.setBidCount(6);

        var trampCount7_3_3 = new BidConfig();
        trampCount7_3_3.setTrampCount(7);
        trampCount7_3_3.setAverageOfTramps(Range.openClosed(7.99F, 8.99F));
        trampCount7_3_3.setPointsFromNonTrampSuit(Range.openClosed(7, 10));
        trampCount7_3_3.setBidCount(7);

        var trampCount7_3_4 = new BidConfig();
        trampCount7_3_4.setTrampCount(7);
        trampCount7_3_4.setAverageOfTramps(Range.openClosed(7.99F, 8.99F));
        trampCount7_3_4.setPointsFromNonTrampSuit(Range.openClosed(10, 15));
        trampCount7_3_4.setBidCount(8);

        var trampCount7_3_5 = new BidConfig();
        trampCount7_3_5.setTrampCount(7);
        trampCount7_3_5.setAverageOfTramps(Range.openClosed(7.99F, 8.99F));
        trampCount7_3_5.setPointsFromNonTrampSuit(Range.greaterThan(15));
        trampCount7_3_5.setBidCount(9);

        var trampCount7_4_1 = new BidConfig();
        trampCount7_4_1.setTrampCount(7);
        trampCount7_4_1.setAverageOfTramps(Range.openClosed(8.99F, 9.99F));
        trampCount7_4_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 4));
        trampCount7_4_1.setBidCount(6);

        var trampCount7_4_2 = new BidConfig();
        trampCount7_4_2.setTrampCount(7);
        trampCount7_4_2.setAverageOfTramps(Range.openClosed(8.99F, 9.99F));
        trampCount7_4_2.setPointsFromNonTrampSuit(Range.openClosed(4, 7));
        trampCount7_4_2.setBidCount(7);

        var trampCount7_4_3 = new BidConfig();
        trampCount7_4_3.setTrampCount(7);
        trampCount7_4_3.setAverageOfTramps(Range.openClosed(8.99F, 9.99F));
        trampCount7_4_3.setPointsFromNonTrampSuit(Range.openClosed(7, 11));
        trampCount7_4_3.setBidCount(8);

        var trampCount7_4_4 = new BidConfig();
        trampCount7_4_4.setTrampCount(7);
        trampCount7_4_4.setAverageOfTramps(Range.openClosed(8.99F, 9.99F));
        trampCount7_4_4.setPointsFromNonTrampSuit(Range.openClosed(11, 15));
        trampCount7_4_4.setBidCount(9);

        var trampCount7_4_5 = new BidConfig();
        trampCount7_4_5.setTrampCount(7);
        trampCount7_4_5.setAverageOfTramps(Range.openClosed(8.99F, 9.99F));
        trampCount7_4_5.setPointsFromNonTrampSuit(Range.greaterThan(15));
        trampCount7_4_5.setBidCount(10);

        var trampCount7_5_1 = new BidConfig();
        trampCount7_5_1.setTrampCount(7);
        trampCount7_5_1.setAverageOfTramps(Range.greaterThan(9.99F));
        trampCount7_5_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 2));
        trampCount7_5_1.setBidCount(7);

        var trampCount7_5_2 = new BidConfig();
        trampCount7_5_2.setTrampCount(7);
        trampCount7_5_2.setAverageOfTramps(Range.greaterThan(9.99F));
        trampCount7_5_2.setPointsFromNonTrampSuit(Range.openClosed(2, 6));
        trampCount7_5_2.setBidCount(8);

        var trampCount7_5_3 = new BidConfig();
        trampCount7_5_3.setTrampCount(7);
        trampCount7_5_3.setAverageOfTramps(Range.greaterThan(9.99F));
        trampCount7_5_3.setPointsFromNonTrampSuit(Range.openClosed(6, 9));
        trampCount7_5_3.setBidCount(9);

        var trampCount7_5_4 = new BidConfig();
        trampCount7_5_4.setTrampCount(7);
        trampCount7_5_4.setAverageOfTramps(Range.greaterThan(9.99F));
        trampCount7_5_4.setPointsFromNonTrampSuit(Range.greaterThan(9));
        trampCount7_5_4.setBidCount(10);

        var trampCount7_6_1 = new BidConfig();
        trampCount7_6_1.setTrampCount(7);
        trampCount7_6_1.setAverageOfTramps(Range.openClosed(5.99F,6.99F));
        trampCount7_6_1.setPointsFromNonTrampSuit(Range.openClosed(-1, 3));
        trampCount7_6_1.setBidCount(0);

        var trampCount7_6_2 = new BidConfig();
        trampCount7_6_2.setTrampCount(7);
        trampCount7_6_2.setAverageOfTramps(Range.openClosed(5.99F,6.99F));
        trampCount7_6_2.setPointsFromNonTrampSuit(Range.openClosed(3, 8));
        trampCount7_6_2.setBidCount(5);

        var trampCount7_6_3 = new BidConfig();
        trampCount7_6_3.setTrampCount(7);
        trampCount7_6_3.setAverageOfTramps(Range.openClosed(5.99F,6.99F));
        trampCount7_6_3.setPointsFromNonTrampSuit(Range.openClosed(8, 11));
        trampCount7_6_3.setBidCount(6);

        var trampCount7_6_4 = new BidConfig();
        trampCount7_6_4.setTrampCount(7);
        trampCount7_6_4.setAverageOfTramps(Range.openClosed(5.99F,6.99F));
        trampCount7_6_4.setPointsFromNonTrampSuit(Range.openClosed(11, 15));
        trampCount7_6_4.setBidCount(7);

        var trampCount7_6_5 = new BidConfig();
        trampCount7_6_5.setTrampCount(7);
        trampCount7_6_5.setAverageOfTramps(Range.openClosed(5.99F,6.99F));
        trampCount7_6_5.setPointsFromNonTrampSuit(Range.greaterThan(15));
        trampCount7_6_5.setBidCount(8);




        this.bidConfigs.add(trampCount5_1_1);
        this.bidConfigs.add(trampCount5_1_2);
        this.bidConfigs.add(trampCount5_1_3);
        this.bidConfigs.add(trampCount5_1_4);

        this.bidConfigs.add(trampCount5_2);

        this.bidConfigs.add(trampCount5_3_1);
        this.bidConfigs.add(trampCount5_3_2);
        this.bidConfigs.add(trampCount5_3_3);
        this.bidConfigs.add(trampCount5_3_4);

        this.bidConfigs.add(trampCount6_1);

        this.bidConfigs.add(trampCount6_2_1);
        this.bidConfigs.add(trampCount6_2_2);
        this.bidConfigs.add(trampCount6_2_3);
        this.bidConfigs.add(trampCount6_2_4);
        this.bidConfigs.add(trampCount6_2_5);
        this.bidConfigs.add(trampCount6_2_6);

        this.bidConfigs.add(trampCount6_3_1);
        this.bidConfigs.add(trampCount6_3_2);
        this.bidConfigs.add(trampCount6_3_3);
        this.bidConfigs.add(trampCount6_3_4);
        this.bidConfigs.add(trampCount6_3_5);
        this.bidConfigs.add(trampCount6_3_6);

        this.bidConfigs.add(trampCount6_4_1);
        this.bidConfigs.add(trampCount6_4_2);
        this.bidConfigs.add(trampCount6_4_3);
        this.bidConfigs.add(trampCount6_4_4);
        this.bidConfigs.add(trampCount6_4_5);

        this.bidConfigs.add(trampCount7_1);

        this.bidConfigs.add(trampCount7_2_1);
        this.bidConfigs.add(trampCount7_2_2);
        this.bidConfigs.add(trampCount7_2_3);
        this.bidConfigs.add(trampCount7_2_4);
        this.bidConfigs.add(trampCount7_2_5);
        this.bidConfigs.add(trampCount7_2_6);

        this.bidConfigs.add(trampCount7_3_1);
        this.bidConfigs.add(trampCount7_3_2);
        this.bidConfigs.add(trampCount7_3_3);
        this.bidConfigs.add(trampCount7_3_4);
        this.bidConfigs.add(trampCount7_3_5);

        this.bidConfigs.add(trampCount7_4_1);
        this.bidConfigs.add(trampCount7_4_2);
        this.bidConfigs.add(trampCount7_4_3);
        this.bidConfigs.add(trampCount7_4_4);
        this.bidConfigs.add(trampCount7_4_5);

        this.bidConfigs.add(trampCount7_5_1);
        this.bidConfigs.add(trampCount7_5_2);
        this.bidConfigs.add(trampCount7_5_3);
        this.bidConfigs.add(trampCount7_5_4);

        this.bidConfigs.add(trampCount7_6_1);
        this.bidConfigs.add(trampCount7_6_2);
        this.bidConfigs.add(trampCount7_6_3);
        this.bidConfigs.add(trampCount7_6_4);
        this.bidConfigs.add(trampCount7_6_5);

    }

    public List<BidConfig> getBidConfig() {
        return bidConfigs;
    }
}
