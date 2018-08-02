package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import regression.AccountTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses(AccountTestSuite.class)
public class TestRunner {

}
