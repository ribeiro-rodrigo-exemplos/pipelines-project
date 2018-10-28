@Library('my-shared')
import org.foo.Utilities 

def utils = new Utilities(this); 

node{
    utils.mvn 'clean package'
}