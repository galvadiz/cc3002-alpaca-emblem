package model.map;

import java.util.*;
import java.lang.*;

/**
 * This class represents the map where the units are located and the game is played.
 * <p>
 * The field is an undirected graph composed of <i>Location</i> nodes where the weight of every edge
 * of the graph is 1.
 * Since all cells of the map should be reachable, the graph must be connected.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Field {

  private Map<String, Location> map = new HashMap<>();
  private long randomSeed = new Random().nextLong();
  private Random random = new Random(randomSeed);
  private StringBuilder builder = new StringBuilder();


  /**
   *
   * @return seed of the current field
   */
  public long getSeed(){
    return randomSeed;
  }

  /**
   *
   * @return seed of the current field
   */
  public void setSeed(long seed){
    random = new Random(seed);
  }

  /**
   * Add cells to the map.
   *  @param connectAll
   *     a flag that indicates if all the cells should be connected to it's neighbours
   * @param cells
   */
  public void addCells(final boolean connectAll, final Location... cells) {
    for (Location cell : cells) {
      addCell(cell);
      Location[] adjacentCells = getAdjacentCells(cell);
      for (Location adjacentCell : adjacentCells) {
        if (connectAll || random.nextDouble() > 1.0 / 3 || cell.getNeighbours().size() < 1) {
          addConnection(cell, adjacentCell);
        }
      }
    }
  }

  /**
   * Adds a cell to the map
   *
   * @param cell
   *     the location to be added
   */
  public void addCell(Location cell) {
    map.put(cell.toString(), cell);
  }

  /**
   * Gets the possible adjacent cells to a given cell
   *
   * @param cell
   *     the location of the current cell
   * @return an array of the adjacent cells
   */
  public Location[] getAdjacentCells(final Location cell) {
    int row = cell.getRow(),
        col = cell.getColumn();
    return new Location[]{getCell(row - 1, col), getCell(row + 1, col), getCell(row, col - 1),
        getCell(row, col + 1)};
  }

  /**
   * Creates a connection between 2 cells
   */
  private void addConnection(Location cell1, Location cell2) {
    cell1.addNeighbour(cell2);
  }

  /**
   * @param row
   *     the row of the cell
   * @param col
   *     the column of the cell
   * @return the Location that represents the cell at (row, col)
   */
  public Location getCell(final int row, final int col) {
    String id = generateID(row, col);
    return map.getOrDefault(id, new InvalidLocation());
  }

  /**
   * Creates a map key from a row and a column
   *
   * @param row
   *     the row of the cell
   * @param col
   *     the column of the cell
   * @return a string of the form (row, col)
   */
  private String generateID(final int row, final int col) {
    builder.setLength(0);
    builder.append("(").append(row).append(", ").append(col).append(")");
    return builder.toString();
  }

  public Map<String, Location> getMap() {
    return Map.copyOf(map);
  }

  /**
   * Checks if the map is connected using BFS.
   *
   * @return true if the map is connected, false otherwise.
   */
  public boolean isConnected() {
    Set<Location> visitedNodes = new HashSet<>();
    Queue<Location> toVisit = new LinkedList<>();
    toVisit.add(map.entrySet().iterator().next().getValue());
    while (!toVisit.isEmpty()) {
      if (visitedNodes.size() == map.size()) {
        return true;
      }
      Location currentNode = toVisit.poll();
      for (Location neighbour :
          currentNode.getNeighbours()) {
        if (!visitedNodes.contains(neighbour)) {
          visitedNodes.add(neighbour);
          toVisit.add(neighbour);
        }
      }
    }
    return false;
  }

  /**
   * Removes a connection from two locations of the field
   */
  public void removeConnection(final Location cell1, final Location cell2) {
    if (cell1.getNeighbours().size() > 1 && cell2.getNeighbours().size() > 1) {
      cell1.removeNeighbour(cell2);
    }
  }

  /**
   * Checks if two cells of the map are connected
   */
  public boolean checkConnection(final Location cell1, final Location cell2) {
    return cell1.isNeighbour(cell2);
  }


  /**
   *
   * @return tamano del mapa
   */
  public int getSize(){
    double sizeMap = (double)map.size();
    return (int)Math.sqrt(sizeMap);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Field)) return false;
    Field that = (Field) o;
    if (this.getSize() != that.getSize()) return false;
    for (String s: map.keySet()){
      if (map.get(s).getNeighbours().size() != that.getMap().get(s).getNeighbours().size()) return false;
      for (Location l: map.get(s).getNeighbours()){
        boolean esta = false;
        for (Location l2: that.getMap().get(s).getNeighbours()){
          if (l2.equals(l)){
            esta = true;
          }
        }
        if (!esta) return false;
      }
    }
    return true;
  }


}
