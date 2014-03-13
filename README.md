java8workshop
=============

This code is the exercises for the java 8 workshop at javaBin Bergen in MArch 2014. The two interfaces represents the
methods to be implemented as part of the exercise. We have provided skeleton implementations and failing junit tests.

The dataset
------------
The dataset is found in src/main/resources/income.csv. The data are copied from Folkehelseinstituttet (http://norgeshelsa.no/norgeshelsa/index.jsp?headers=AAR&AARslice=2011&stubs=GEO_LF&stubs=KJONN_BMK&KJONN_BMKslice=0&KJONN_BMKsubset=0%2C1+-+2&GEO_LFslice=0&measure=common&virtualslice=KRONER_value&layers=virtual&study=http%3A%2F%2F158.36.43.171%3A80%2Fobj%2FfStudy%2F0800&mode=cube&v=2&virtualsubset=KRONER_value&AARsubset=1997+-+2011&measuretype=4&cube=http%3A%2F%2F158.36.43.171%3A80%2Fobj%2FfCube%2F0800_C1&GEO_LFsubset=0%2C1+-+20&top=yes).
The table shows the average income in NOK for the years 1997 to 2012 separated into counties and sexes in Norway.

We have provided a class, IncomeStatistics, that contains the fields county, year, gender and average income. Most of
the exercises will be working with the collection of IncomeStatistics objects.

The structure of the workshop
-----------------------------
The workshop is divided into three parts. Each part will consist of a (brief) introduction to some new features in
java 8 followed by some related exercises for you to solve.