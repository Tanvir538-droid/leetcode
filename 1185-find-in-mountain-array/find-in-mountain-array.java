/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex = findPeakIndex(0,length - 2, mountainArr);
        int firstIndex = findIndex(0,peakIndex,target,mountainArr,false);
        if(mountainArr.get(firstIndex)==target){
            return firstIndex;
        }
        int secondIndex = findIndex(peakIndex +1 ,length -1,target,mountainArr,true);
        if(mountainArr.get(secondIndex)==target){
            return secondIndex;
        }

        return -1;
    }

    public int findPeakIndex(int start,int end,MountainArray mountainArr){
        while(start<end){
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    public int findIndex(int start , int end ,int target, MountainArray mountainArr,boolean check){
        while(start!=end){
            int  mid = start + (end - start)/2;
            if(check){
                if(mountainArr.get(mid)>target){
                    start = mid + 1;
                }else{
                    end = mid;
                }

            }else{
                if(mountainArr.get(mid)<target){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
        }
        return start;
    }
}