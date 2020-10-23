# Practice5

# 15 functions that can be applied in data frames in the scala language.

## where. Filter rows using the given condition.
val wheredf = df.where($"Date" === "2006-01-06")
wheredf.show()
