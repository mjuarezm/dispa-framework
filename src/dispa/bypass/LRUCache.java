package dispa.bypass;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <code>LRUCache</code> is an implementation of a cache following an LRU
 * policy based on a <code>LinkedHashMap</code>. The cache contains keys
 * with an associated value of a generic type.
 *
 * @author mjuarez@iiia.csic.es
 * @param <K>
 * 		the key of the cache entry.
 * @param <V>
 * 		the value of the entry associated to <code><K></code>.
 * @see java.util.LinkedHashMap
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V>
		implements Serializable {
	/**
	 * UID of the class for serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Maximum number of entries in the cache.
	 */
	private final int maxEntries;

	/**
	 * Default constructor of the cache.
	 *
	 * @param newMaxEntries
	 * 		the maximum number of entries in the cache.
	 */
	public LRUCache(final int newMaxEntries) {
		super(newMaxEntries + 1, 1.0f, true);
		this.maxEntries = newMaxEntries;
	}

	/**
	 * Returns <tt>true</tt> if this <code>LRUCache</code> has more entries
	 * than the maximum specified when it was created.
	 *
	 * <p>
	 * This method <em>does not</em> modify the underlying <code>Map</code>;
	 * it relies on the implementation of <code>LinkedHashMap</code> to do
	 * that, but that behavior is documented in the JavaDoc for
	 * <code>LinkedHashMap</code>.
	 * </p>
	 *
	 * @param eldest
	 * 		the <code>Entry</code> in question; this implementation
	 *      doesn't care what it is, since the implementation is only
	 *      dependent on the size of the cache.
	 * @return <tt>true</tt> if the oldest
	 * @see java.util.LinkedHashMap#removeEldestEntry(Map.Entry)
	 */
	@Override
	protected final boolean
			removeEldestEntry(final Map.Entry<K, V> eldest) {
		return super.size() > maxEntries;
	}
}