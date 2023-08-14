package org.example.model;

import com.google.common.collect.Range;

public class BidConfig {

    private Integer trampCount;
    private Range<Float> averageOfTramps;

    private Range<Integer> pointsFromNonTrampSuit;

    private Integer bidCount;


    public Integer getTrampCount() {
        return trampCount;
    }

    public void setTrampCount(Integer trampCount) {
        this.trampCount = trampCount;
    }

    public Range<Float> getAverageOfTramps() {
        return averageOfTramps;
    }

    public void setAverageOfTramps(Range<Float> averageOfTramps) {
        this.averageOfTramps = averageOfTramps;
    }

    public Range<Integer> getPointsFromNonTrampSuit() {
        return pointsFromNonTrampSuit;
    }

    public void setPointsFromNonTrampSuit(Range<Integer> pointsFromNonTrampSuit) {
        this.pointsFromNonTrampSuit = pointsFromNonTrampSuit;
    }

    public Integer getBidCount() {
        return bidCount;
    }

    public void setBidCount(Integer bidCount) {
        this.bidCount = bidCount;
    }

    @Override
    public String toString() {
        return "MyBidConfig{" +
                "trampCount=" + trampCount +
                ", averageOfTramps=" + averageOfTramps +
                ", pointsFromNonTrampSuit=" + pointsFromNonTrampSuit +
                ", bidCount=" + bidCount +
                '}';
    }
}
