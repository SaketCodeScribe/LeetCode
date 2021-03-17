#define d double
#define v1 vector<double>
#define v2 vector<v1>
#define pi 3.141592
class Solution {
public:
    d x, y, r;
    double randgen(){
        return ((double)rand()/(double)RAND_MAX);
    }
    Solution(double radius, double x_center, double y_center) {
        r=radius;
        x=x_center;
        y=y_center;
    }

    v1 randPoint() {
        d h=r*sqrt(randgen());
        d theta=2*pi*randgen();
        d rx, ry;
        rx=x+h*cos(theta);
        ry=y+h*sin(theta);
        return {rx,ry};
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(radius, x_center, y_center);
 * vector<double> param_1 = obj->randPoint();
 */