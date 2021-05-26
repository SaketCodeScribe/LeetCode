/**
 * @Time: O(n)
 * @Space: O(1)
 * /

/**
 * @param {string} s
 * @return {boolean}
 */
var checkZeroOnes = function(s) {
    let ones = 0, zeros = 0, mx_1 = 0, mx_0 = 0
    for(val of s){
        if (val == '1'){
            mx_0 = zeros > mx_0 ? zeros : mx_0 
            zeros = 0
            ones++
        }
        else{
            mx_1 = ones > mx_1 ? ones : mx_1 
            ones = 0
            zeros++
        }
    }
    mx_0 = zeros > mx_0 ? zeros : mx_0
    mx_1 = ones > mx_1 ? ones : mx_1
    return mx_1 > mx_0
};