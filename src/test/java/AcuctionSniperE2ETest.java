import org.junit.jupiter.api.Test;

public class AuctionSniperE2ETest {
    private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");

    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void sniperJoinsAuctionUntilAuctionClosed() throws Exception {
        auction.startSellingItem();
        application.startBiddingIn(auction);
        auction.hasReceivedJoinRequestFromSniper();
        auction.announceClosed();
        application.showSniperHasLostAuction();
    }
}
