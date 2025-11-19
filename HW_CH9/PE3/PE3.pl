use strict;
use warnings;

sub change_value {
    my ($ref) = @_;
    print "(inside sub) Before change: $$ref\n";
    $$ref = 42;
    print "(inside sub) After change: $$ref\n";
}

my $x = 10;
print ("Calling with x = $x\n");
change_value(\$x);
print ("After sub call, x = $x\n");

print "Calling with literal 100\n";
change_value(\100);  # This will cause an error because you cannot take a reference to
print ("This line will not be executed due to the error above.\n");