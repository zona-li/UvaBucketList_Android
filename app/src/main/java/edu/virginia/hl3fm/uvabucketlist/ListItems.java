package edu.virginia.hl3fm.uvabucketlist;

import java.util.ArrayList;

/**
 * This is the model class for the RecyclerView which contains each bucket list item's
 * title, date it needs to be completed, and whether it is completed or not.
 */

public class ListItems {
    private boolean mCompletion;
    private String mDate;
    private String mTitle;

    public ListItems() {}

    public ListItems(boolean completion, String date, String title) {
        mCompletion = completion;
        mDate = date;
        mTitle = title;
    }

    // Get ListItem attributes methods
    public boolean isCompleted() {
        return mCompletion;
    }
    public String getDate() {
        return mDate;
    }
    public String getTitle() { return mTitle; }

    // Set ListItem attributes methods
    public void setTitle(String title) { mTitle = title; }
    public void setCompletion(Boolean isCompleted) { this.mCompletion = isCompleted; }
    public void setCompletedDate(String date) { this.mDate = date; }

    /*
    // Method to create an array of ListItems with default attributes
    public static ArrayList<ListItems> createBucketList(int num) {
        ArrayList<ListItems> bucketList = new ArrayList<ListItems>();
        for (int i = 0; i < num; i++) {
            bucketList.add(new ListItems(true, "12.1.2016", "Apply for graduation"));
        }
        return bucketList;
    }
    */
}
