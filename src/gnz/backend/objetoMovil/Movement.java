package gnz.backend.objetoMovil;
/**
 *
 * @author helmuth
 */
public class Movement {
    
    private MotorType motor;
    private MovementType type;
    private final SpeedLevel speed;
    private int distance;
    private int angle;
    private int radio;
    private Orientation orientation1;
    private Orientation orientation2;

    public Movement(MovementType type, MotorType motor, SpeedLevel speed, int distance, Orientation orientation) {
        this.type = type;
        this.motor = motor;
        this.speed = speed;
        this.distance = distance;
        this.orientation1 = orientation;
    }

    public Movement(MovementType type, SpeedLevel speed, int distance, Orientation orientation) {
        this.type = type;
        this.speed = speed;
        this.distance = distance;
        this.orientation1 = orientation;
    }

    public Movement(MovementType type, SpeedLevel speed, int distance, int angle) {
        this.type = type;
        this.speed = speed;
        this.distance = distance;
        this.angle = angle;
    }

    public Movement(MovementType type, int radio, SpeedLevel speed, Orientation orientation1, Orientation orientation2) {
        this.radio = radio;
        this.type = type;
        this.speed = speed;
        this.orientation1 = orientation1;
        this.orientation2 = orientation2;
    }
    
    public MotorType getMotor() {
        return motor;
    }

    public SpeedLevel getSpeed() {
        return speed;
    }

    public int getDistance() {
        return distance;
    }

    public MovementType getType() {
        return type;
    }

    public int getAngle() {
        return angle;
    }

    public int getRadio() {
        return radio;
    }

    public Orientation getOrientation1() {
        return orientation1;
    }

    public Orientation getOrientation2() {
        return orientation2;
    }
    
    public static enum MotorType{
        MOTORA,
        MOTORB,
        MOTORC,
        MOTORD
    }
    
    public static enum SpeedLevel{
        SPEED1,
        SPEED2,
        SPEED3
    }
    
    public static enum Orientation{
        AHEAD,
        BEHIND,
        UP,
        DOWN
    }
    
    public static enum MovementType{
        STRAIGHT,
        CURVED,
        DIAGONAL,
        BASE
    }
            
}
