$2 ~ /\.puml$/ \
{
  filenameMatcher="([[:alpha:][:digit:]/-]+/)?([[:alpha:][:digit:]-]+).puml$"
  path=gensub( filenameMatcher,"\\1.svg/MODE/\\2.svg", "1", $2 )
  lightDir=gensub( filenameMatcher, "\\1.svg/light", "1", $2 )
  darkDir=gensub( filenameMatcher, "\\1.svg/dark", "1", $2 )

  light=gensub(/MODE/, "light", "g", path);
  dark=gensub(/MODE/, "dark", "g", path);
  if( $1 !~ /^D$/ ) {
    # added or modified
    changed=( changed == "" ? "" : changed " " ) $2
    # light changed svg
    lcs=( lcs == "" ? "" : lcs " " ) light
    dcs=( dcs == "" ? "" : dcs " " ) dark

    # directories
    lcsd=( lcsd == "" ? "" : lcsd " " ) lightDir
    dcsd=( dcsd == "" ? "" : dcsd " " ) darkDir
  }
  else {
    # removed
    lrs=( lrs == "" ? "" : lrs " " ) light
    drs=( drs == "" ? "" : drs " " ) light
  }
}
END {
  printf "::set-output name=config-change::%s\n", ( $2 ~ /(theme|config)\.puml$/ ) ? "true" : "false"
  printf "::set-output name=light-dir::%s\n", lcsd
  printf "::set-output name=dark-dir::%s\n", dcsd
  printf "::set-output name=changed::%s\n", changed
  printf "::set-output name=changed-light::%s\n", lcs
  printf "::set-output name=changed-dark::%s\n", dcs
  printf "::set-output name=removed-light::%s\n", lrs
  printf "::set-output name=removed-dark::%s\n", drs
}
