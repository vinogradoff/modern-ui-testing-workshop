package widgetobjects;

import com.codeborne.selenide.*;
import io.qameta.allure.*;

import static com.codeborne.selenide.Selenide.*;

public class RepositoriesFound {

    ElementsCollection repos = $$(".repo-list li");

    /***
     * opens repository page
     * @param index 0..N - number of the repository in the list
     */
    @Step("open the repository number {index} from the list")
    public void openRepositoryFound(int index) {
        repos.get(index).$(("a")).click();
    }

}
