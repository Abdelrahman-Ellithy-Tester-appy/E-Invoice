package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.util.Map;

public class LocatorsMap {
    private static final Map<DropDownOptions, By> OptionsKeyMap;
    private static final Map<ServerMode, By> ServerKeyMap;
    private static final Map<Client, By> ClientKeyMap;
    static {
        OptionsKeyMap = Map.ofEntries(
                Map.entry(DropDownOptions.Company_Building_1, AppiumBy.accessibilityId("Company Building1 - مباني المؤسسة1")),
                Map.entry(DropDownOptions.Main, AppiumBy.accessibilityId("Main Branch - فرع رئيسي")),
                Map.entry(DropDownOptions.shereen_branch_bill, AppiumBy.accessibilityId("shereen branch-bill - فرع شيرين-سند"))
        );
        ServerKeyMap=Map.ofEntries(
                Map.entry(ServerMode.SERVER_MODE, AppiumBy.accessibilityId("Server - خارجي")),
                Map.entry(ServerMode.LOCAL_MODE, AppiumBy.accessibilityId("Local - داخلي"))
        );
        ClientKeyMap=Map.ofEntries(
                Map.entry(Client.ghhhhhhkhh, AppiumBy.accessibilityId("ghhhhhhkhh - khhhghh")),
                Map.entry(Client.Mohammed_Abdelgwad, AppiumBy.accessibilityId("محمد عبدالجواد - Mohammed Abdelgwad"))
        );
    }
    public static By getKeyName(DropDownOptions option) {
        return OptionsKeyMap.get(option);
    }
    public static By getKeyName(ServerMode serverMode) {
        return ServerKeyMap.get(serverMode);
    }
    public static By getKeyName(Client client) {
        return ClientKeyMap.get(client);
    }
}
