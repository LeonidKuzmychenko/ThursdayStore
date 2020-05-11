package com.example.thursdaystore.api.suite

import com.example.thursdaystore.api.Categories
import com.example.thursdaystore.api.Languages
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(Languages::class, Categories::class)
class ApiSuite