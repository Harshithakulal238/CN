set ns [new Simulator]

set tracefile  [open lab08.tr w]
$ns trace-all $tracefile

set namfile [open lab08.nam w]
$ns namtrace-all $namfile

proc finish {} {
global ns tracefile namfile 
$ns flush-trace

close $tracefile
close $namfile  

exec nam lab08.nam &

exec awk -f lab08.awk lab08.tr &
exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

$n0 label "TCPsource"
$n2 label "TCPsink"

$ns color 1 red

$ns duplex-link $n0 $n1 2.00Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns queue-limit $n1 $n2 5

set tcp [new Agent/TCP]
$ns attach-agent $n0 $tcp

set tcpsink [new Agent/TCPSink]
$ns attach-agent $n2 $tcpsink

set ftp [new Application/FTP]
$ftp attach-agent $tcp

$ns connect $tcp $tcpsink
$tcp set class_ 1

$ns at 0.2 "$ftp start"
$ns at 2.5 "$ftp stop"
$ns at 3.0 "finish"
$ns run
