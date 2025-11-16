import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    AdminLoginTest.class,
    InvalidAdminLoginTest.class,
    InviteNewUserTest.class,
    DeleteUserTest.class,
    AddNewWebsiteTest.class,
    AddNewIntranetWebsiteTest.class,
    ConfigureCustomVisitDimensionTest.class,
    ConfigureCustomActionDimensionTest.class,
    CreateWebsiteReportTest.class,
    CreateIntranetWebsiteReportTest.class,
    AddWebsiteGoalTest.class,
    AddIntranetWebsiteGoalTest.class,
    EditWebsiteTest.class,
    EditIntranetWebsiteTest.class,
    EditWebsiteGoalTest.class,
    EditIntranetWebsiteGoalTest.class,
    DeleteWebsiteGoalTest.class,
    DeleteIntranetWebsiteGoalTest.class,
    DeleteWebsiteTest.class,
    DeleteIntranetWebsiteTest.class,
    LogoutUserTest.class,
    ChangeUserPasswordTest.class
})
public class TestSuite {
}