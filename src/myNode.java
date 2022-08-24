public class myNode <V>{

        private V val;
        private myNode next;
        private myNode prev;

        public myNode(V val){
            this.val=val;
        }
        public myNode<V> getPrev() {
            return prev;
        }
        public void setPrev(myNode prev) {
            this.prev = prev;
        }
        public V getVal() {
            return this.val;
        }
        public myNode<V> getNext() {
            return next;
        }
        public void setNext(myNode next) {
            this.next = next;
        }
        public void setVal(V val) {
            this.val = val;
        }
    }

