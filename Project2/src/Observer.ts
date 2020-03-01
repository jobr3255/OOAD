// import Subject from "./Subject"
/**
 *  Observer interface for Zookeeper
 */
export default interface Observer {
    update: () => void;
}
