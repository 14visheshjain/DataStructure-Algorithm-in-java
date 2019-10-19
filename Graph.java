package lecture9a25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private class vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		vertex vtx = new vertex();
		this.vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		vertex vtx = vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			vtces.get(key).nbrs.remove(vname);
		}
		vtces.remove(vname);

	}

	public int numEdges() {
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;
		for (String key : keys) {
			count += vtces.get(key).nbrs.size();
		}
		return count / 2;

	}

	public boolean containsedge(String vname1, String vname2) {
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return false;
		return true;

	}

	public void addEdge(String vname1, String vname2, int cost) {
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2))
			return;
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);

	}

	public void removeEdge(String vname1, String vname2) {
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return;
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {
		System.out.println("-------------------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			vertex vtx = vtces.get(key);
			System.out.println(key + "-> " + vtx.nbrs);
		}
		System.out.println("-------------------------------------");
	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {
		if (containsedge(vname1, vname2)) {
			return true;
		}
		vertex vtx = vtces.get(vname1);

		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		processed.put(vname1, true);
		for (String key : keys) {
			if (!processed.containsKey(key) && hasPath(key, vname2, processed))
				return true;

		}
		processed.remove(vname1);
		return false;
	}

	private class Pair {
		String name;
		String psf;//path covered
		String colour;
	}

	public boolean BreadthFirstSeacrch(String src, String dst) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// 1.make a pair and add in queue
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;
		queue.addLast(sp);

		// 2.work till queue is not empty
		while (!queue.isEmpty()) {
			// 2.1 remove the pair from queue
			Pair rp = queue.removeFirst();

			// 2.2 processed
			if (processed.containsKey(rp.name)) {
				continue;
			}
			processed.put(rp.name, true);
			// 2.3 direct edge
			if (vtces.get(rp.name).nbrs.containsKey(dst)) {
				System.out.println(rp.psf + "" + dst);
				return true;
			}
			// 2.4 nbrs
			for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
			}
		}

		return false;
	}

	public boolean DepthFirstSeacrch(String src, String dst) {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// 1.make a pair and add in queue
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;
		stack.addFirst(sp);

		// 2.work till queue is not empty
		while (!stack.isEmpty()) {
			// 2.1 remove the pair from queue
			Pair rp = stack.removeFirst();

			// 2.2 processed
			if (processed.containsKey(rp.name)) {
				continue;
			}
			processed.put(rp.name, true);
			// 2.3 direct edge
			if (vtces.get(rp.name).nbrs.containsKey(dst)) {
				System.out.println(rp.psf + "" + dst);
				return true;
			}
			// 2.4 nbrs
			for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public void BreadthFirstTaversal() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {
			if (processed.containsKey(src)) {
				continue;
			}
			// 1.make a pair and add in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			// 2.work till queue is not empty
			while (!queue.isEmpty()) {
				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				// 2.2 processed
				if (processed.containsKey(rp.name)) {
					continue;
				}
				processed.put(rp.name, true);
				// 2.3 direct edge
				System.out.println(rp.name + " via " + rp.psf);
				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf +nbr;
						queue.addLast(np);
					}
				}
			}

		}
	}

	public void DepthFirstTaversal() {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {
			if (processed.containsKey(src)) {
				continue;
			}
			// 1.make a pair and add in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			stack.addFirst(sp);

			// 2.work till queue is not empty
			while (!stack.isEmpty()) {
				// 2.1 remove the pair from queue
				Pair rp = stack.removeFirst();

				// 2.2 processed
				if (processed.containsKey(rp.name)) {
					continue;
				}
				processed.put(rp.name, true);
				// 2.3 direct edge
				System.out.println(rp.name + " via " + rp.psf);
				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						stack.addFirst(np);
					}
				}
			}

		}
	}

	public boolean IsConnected() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		int count = 0;
		for (String src : vtces.keySet()) {
			if (processed.containsKey(src)) {
				continue;
			}
			count++;
			// 1.make a pair and add in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			// 2.work till queue is not empty
			while (!queue.isEmpty()) {
				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				// 2.2 processed
				if (processed.containsKey(rp.name)) {
					continue;
				}
				processed.put(rp.name, true);
				// 2.3 direct edge
				System.out.println(rp.name + " via " + rp.psf);
				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}

		}
		return count == 1;
	}

	public boolean IsCyclic() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {
			if (processed.containsKey(src)) {
				continue;
			}
			// 1.make a pair and add in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			// 2.work till queue is not empty
			while (!queue.isEmpty()) {
				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				// 2.2 processed
				if (processed.containsKey(rp.name)) {
					return true;

				}
				processed.put(rp.name, true);
				// 2.3 direct edge
				System.out.println(rp.name + " via " + rp.psf);
				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}

		}
		return false;
	}

	public boolean isTree() {
		return IsConnected() && !IsCyclic();
	}

	public ArrayList<ArrayList<String>> getCC() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		for (String src : vtces.keySet()) {
			if (processed.containsKey(src)) {
				continue;
			}
			arr.add(new ArrayList<>());
			// 1.make a pair and add in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			// 2.work till queue is not empty
			while (!queue.isEmpty()) {
				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				// 2.2 processed
				if (processed.containsKey(rp.name)) {
					continue;
				}
				processed.put(rp.name, true);
				// 2.3 direct edge
				arr.get(arr.size() - 1).add(rp.name);
				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}

		}
		return arr;
	}

	public boolean isBipertite() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, String> processed = new HashMap<>();

		for (String src : vtces.keySet()) {
			if (processed.containsKey(src)) {
				continue;
			}
			// 1.make a pair and add in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			sp.colour = "r";
			queue.addLast(sp);

			// 2.work till queue is not empty
			while (!queue.isEmpty()) {
				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				// 2.2 processed
				if (processed.containsKey(rp.name)) {
					String oc = processed.get(rp.name);
					String nc = rp.colour;
					if (!oc.equals(nc)) {
						return false;
					}
					continue;
				}
				processed.put(rp.name, rp.colour);
				// 2.3 direct edge
				// System.out.println(rp.name + " via " + rp.psf);
				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						np.colour = rp.colour.equals("r") ? "g" : "r";
						queue.addLast(np);
					}
				}
			}

		}
		return true;
	}

}
