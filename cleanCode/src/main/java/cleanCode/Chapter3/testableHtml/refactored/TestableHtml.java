package cleanCode.Chapter3.testableHtml.refactored;

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class TestableHtml {
    public static String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
        return new SetupTeardownSurrounder(pageData, includeSuiteSetup).surround();
    }

    private static class SetupTeardownSurrounder {
        private PageData pageData;
        private boolean includeSuiteSetup;
        private WikiPage wikiPage;
        private String content;
        private PageCrawler crawler;

        public SetupTeardownSurrounder(PageData pageData, boolean includeSuiteSetup) {
            this.pageData = pageData;
            this.includeSuiteSetup = includeSuiteSetup;
            wikiPage = pageData.getWikiPage();
            content = "";
            crawler = wikiPage.getPageCrawler();
        }

        public String surround() throws Exception {
            if (isTestPage())
                surroundPageWithStepsAndTearDowns();

            return pageData.getHtml();
        }

        private void surroundPageWithStepsAndTearDowns() throws Exception {
            content += includeSetups();
            content += pageData.getContent() + "\n";
            content += includeTearDowns();
            pageData.setContent(content);
        }

        private boolean isTestPage() throws Exception {
            return pageData.hasAttribute("Test");
        }

        private String includeTearDowns() throws Exception {
            String teardowns = "";
            teardowns += includeIfInherited("teardown", "TearDown");
            if (includeSuiteSetup)
                teardowns += includeIfInherited("teardown", SuiteResponder.SUITE_TEARDOWN_NAME);

            return teardowns;
        }

        private String includeSetups() throws Exception {
            String setups = "";
            if (includeSuiteSetup)
                setups += includeIfInherited("setup", SuiteResponder.SUITE_SETUP_NAME);
            setups += includeIfInherited("setup", "SetUp");

            return setups;
        }

        private String includeIfInherited(String mode, String pageName) throws Exception {
            WikiPage page = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
            if (page != null)
                return includePage(page, mode);

            return "";
        }

        private String includePage(WikiPage page, String mode) throws Exception {
            WikiPagePath pagePath = crawler.getFullPath(page);
            String pagePathName = PathParser.render(pagePath);

            return String.format("!include -%s .%s\n", mode, pagePathName);
        }
    }
}
