
#       rdiff [options] signature old-file signature-file

#       rdiff [options] delta signature-file new-file delta-file

#       rdiff [options] patch basis-file delta-file new-file

rdiff signature log.file log.signature_cmd
rdiff delta log.signature_cmd log.file.new log.delta_cmd
