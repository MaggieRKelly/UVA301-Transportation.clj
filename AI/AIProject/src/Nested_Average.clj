(defn nested-average [tree]
       (/ (reduce + (flatten tree))(count (flatten tree))))

(defn sum-tree [tree]
  (cond
    (number? tree)  tree                               		;Check if pulled value is a number, then passes the tree again
    (not (seq tree))  0
    :else
    (+ (sum-tree (first tree)) (sum-tree (rest tree))) 		;Otherwise add the first to the tree to the last of the tree
    ))


(defn sum
  ([tree] (sum tree 0))
  ([tree acc-total]
   (if (empty? tree)
     acc-total
     (sum (rest tree) (+ (first tree) acc-total)))))

=> #'user/sum

(sum [39 5 1])
=> 45


(defn sum
  ([tree] (sum tree 0))
  ([tree acc-total]
   (if (empty? tree)
     acc-total
     (recur (rest tree) (+ (first tree) acc-total)))))
=> #'user/sum

(sum [2 4 6 12])
=> 24