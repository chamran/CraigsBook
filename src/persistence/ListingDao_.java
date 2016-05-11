package persistence;

import entity.Listing;

import java.util.List;

/**
 * Created by Student on 5/4/2016.
 */
public interface ListingDao_ {

    public List<Listing> getListingsByQuery(String category, String restrict);

    public void deleteListing(Listing listing);

    public int addListing(Listing listing);


}
