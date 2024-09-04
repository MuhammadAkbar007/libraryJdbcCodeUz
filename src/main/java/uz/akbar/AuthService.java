package uz.akbar;

import uz.akbar.enums.ProfileRole;
import uz.akbar.enums.ProfileStatus;
import uz.akbar.util.MD5Util;

/**
 * AuthService
 */
public class AuthService {

	public void login(String login, String password) {
		ProfileRepository profileRepository = new ProfileRepository();
		Profile profile = profileRepository.getByLogin(login);

		if (profile == null || !MD5Util.encode(password).equals(profile.getPassword())) {
			System.out.println("Login or password incorrect!");
			return;
		}

		if (!profile.getStatus().equals(ProfileStatus.ACTIVE)) {
			System.out.println("Wrong status!");
			return;
		}

		System.out.println("*** Welcome to Library Project ***");

		/* redirect */
		if (profile.getRole().equals(ProfileRole.STUDENT)) {
			StudentController studentController = new StudentController();
			studentController.start();
		} else if (profile.getRole().equals(ProfileRole.ADMIN)) {
			new AdminController().start();
		} else if (profile.getRole().equals(ProfileRole.STAFF)) {
			new StaffController().start();
		}
	}
}
