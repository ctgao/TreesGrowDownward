import org.junit.Assert;
import org.junit.Test;

public class TreeOneZeroTest {
    @Test
    public void constructorNullTest(){
        //Given
        TreeOneZero tree = new TreeOneZero();
        //When
        Node actual = tree.root;
        //Then
        Assert.assertNull(actual);
    }

    @Test
    public void constructorNotNullTest(){
        //Given
        Integer expected = 6;
        TreeOneZero tree = new TreeOneZero(6);
        //When
        Integer actual = tree.root.value;
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addLeftTest() {
        //Given
        Integer expected = 4;
        TreeOneZero tree = new TreeOneZero(6);
        //When
        tree.add(expected);
        Integer actual = tree.root.left.value;
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void addRightTest() {
        //Given
        Integer expected = 8;
        TreeOneZero tree = new TreeOneZero(6);
        //When
        tree.add(expected);
        Integer actual = tree.root.right.value;
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsNodeTest() {
        //Given
        Integer input = 6;
        TreeOneZero tree = new TreeOneZero(input);
        //When
        boolean actual = tree.containsNode(input);
        //Then
        Assert.assertEquals(true, actual);
    }
    @Test
    public void doesNotContainNodeTest() {
        //Given
        Integer input = 6;
        TreeOneZero tree = new TreeOneZero(5);
        //When
        boolean actual = tree.containsNode(input);
        //Then
        Assert.assertEquals(false, actual);
    }

    @Test
    public void deleteRootTest() {
        //Given
        Integer input = 8;
        TreeOneZero tree = new TreeOneZero(input);
        //When
        tree.delete(input);
        Node actual = tree.root;
        //Then
        Assert.assertNull(actual);
    }
    @Test
    public void deleteTest() {
        //Given
        Integer input = 8;
        TreeOneZero tree = new TreeOneZero(6);
        tree.add(input);
        //When
        tree.delete(input);
        //Then
        Assert.assertNull(tree.root.right);
    }
    @Test
    public void deleteMoreTest(){
        //Given
        TreeOneZero tree = new TreeOneZero(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        //When
        Assert.assertTrue(tree.containsNode(9));
        tree.delete(9);
        //Then
        Assert.assertFalse(tree.containsNode(9));
    }
}