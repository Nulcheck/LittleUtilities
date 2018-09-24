package lu.com.mce.util.updater;

public class CheckVersion {
	public CheckVersion(){
		System.out.println("LittleUtilities is checking for updates.");
		
		try{
			if(Integer.parseInt(UpdateInfo.getLatestVersion()) > UpdateInfo.thisVersion){
				System.out.println("LittleUtilities has an update!");
			} else {
				System.out.println("No updates found for LittleUtilities.");
			}
		} catch (Exception e){
			System.out.println("An error has occurred while checking for LittleUtilities updates! Error ID: 000");
			e.printStackTrace();
		}
	}
}
