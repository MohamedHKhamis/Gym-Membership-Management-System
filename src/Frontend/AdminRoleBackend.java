package Frontend;

import Backend.AdminRole;

public class AdminRoleBackend {
    private AdminRole adminRole;
    private AdminRoleWindow adminRoleWindow;
    public AdminRoleBackend() {
        adminRole = new AdminRole();
        adminRoleWindow = new AdminRoleWindow();

    }
    public AdminRoleWindow getFrame(){
        return adminRoleWindow;
    }
    public void logout(){
        adminRole.logout();
        adminRoleWindow.dispose();
    }
}
