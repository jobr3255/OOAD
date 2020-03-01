import Observer from "./Observer"
/**
 *  Subject interface for ZooAnnouncer
 */
export default interface Subject {
    observer: Observer;
    notifyObserver: () => void;
    setObserver: (observer: Observer) => void;
    removeObserver: () => void;
}
