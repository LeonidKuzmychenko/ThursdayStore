package my.diploma.thursdaystore.api.suite

import my.diploma.thursdaystore.api.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    Admin::class,
    Categories::class,
    Colors::class,
    Languages::class,
    Locale::class,
    Parameters::class,
    Products::class,
    Properties::class,
    Subcategories::class)
class ApiSuite