package jar;

import net.serenitybdd.jbehave.SerenityStories;
import java.util.Arrays;
import java.util.List;

public class AcceptanceTestSuite extends SerenityStories {
    public AcceptanceTestSuite(){
        
/*        Un-comment IE or Chrome only for execution as jUnit Test
* 
        System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
        runSerenity().withDriver("iexplorer");
        
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");        
        runSerenity().withDriver("chrome");*/
        
        System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");        
        runSerenity().withDriver("firefox");
    }

    public List<String> storyPaths(){
        return Arrays.asList("stories/resident_id/demo_api.story");
    }
}
