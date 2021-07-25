package widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class RepositoriesFound {

    ElementsCollection repos = $$(".repo-list li");

    /***
     * opens repository page
     * @param index 0..N - number of the repository in the list
     */
    public void openRepositoryFound(int index) {
        repos.get(index).$(("a")).click();
    }

}
