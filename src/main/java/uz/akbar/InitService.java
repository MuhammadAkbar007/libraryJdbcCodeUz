package uz.akbar;

import java.time.LocalDateTime;

import uz.akbar.enums.ProfileRole;
import uz.akbar.enums.ProfileStatus;
import uz.akbar.util.MD5Util;

/**
 * InitService
 */
public class InitService {

    public void initAdmin() {
        String login = "adminjon";
        ProfileRepository profileRepository = new ProfileRepository();
        Profile profile = profileRepository.getByLogin(login);

        if (profile == null) {
            Profile admin = new Profile("Admin aka", "Adminov", login, MD5Util.encode("12345"), "998901234567",
                    ProfileStatus.ACTIVE,
                    ProfileRole.ADMIN, LocalDateTime.now());

            profileRepository.create(admin);
        }
    }

    public void initTestStudent() {
        String login = "testStudent";
        ProfileRepository profileRepository = new ProfileRepository();
        Profile profile = profileRepository.getByLogin(login);

        if (profile == null) {
            Profile testStudent = new Profile(
                    "Studentjon",
                    "Studentov",
                    login,
                    MD5Util.encode("12345"),
                    "998901234567",
                    ProfileStatus.ACTIVE,
                    ProfileRole.STUDENT, LocalDateTime.now()
            );

            profileRepository.create(testStudent);
        }
    }
}
