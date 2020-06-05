package my.diploma.thursdaystore.api.suite

import my.diploma.thursdaystore.api.Categories
import my.diploma.thursdaystore.api.Languages
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(Languages::class, Categories::class)
class ApiSuite