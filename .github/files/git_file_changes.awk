$2 ~ /\.puml$/ && $2 !~ /(theme|config)\.puml$/
{
  if($1 !~ /^D$/) {
    result1= (result1!=""? result1 " " $2: $2)
  }
  else {
      split($2, fn, ".")
      result2=(result2!=""? result2 " " fn[1]: fn[1]) ".svg"
  }
}
END {
  printf "::set-output name=gen-files::%s\n::warning::%s\n", result1, result1
  printf "::set-output name=del-files::%s\n::warning::%s\n", result2, result2
}
