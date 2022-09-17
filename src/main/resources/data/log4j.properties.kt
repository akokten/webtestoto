package data

# Root logger option
log4j.rootLogger=INFO,HTML, stdout, file

# Redirect log messages to console
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

# Redirect log messages to a log file, support file rolling.

log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/${current.date.time}.txt
log4j.appender.file.MaxFileSize=5MB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
log4j.appender.LOGFILE.Append=false



# Define the file appender
log4j.appender.HTML=org.apache.log4j.FileAppender
log4j.appender.HTML.File=./log/test.html

# Define the html layout for file appender
log4j.appender.HTML.layout=org.apache.log4j.HTMLLayout
log4j.appender.HTML.layout.Title=Application logs
log4j.appender.HTML.layout.LocationInfo=true
log4j.appender.HTML.Threshold=DEBUG