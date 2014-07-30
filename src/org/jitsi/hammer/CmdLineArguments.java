/*
 * Jitsi-Hammer, A traffic generator for Jitsi Videobridge.
 */

package org.jitsi.hammer;

import org.jitsi.hammer.utils.*;
import org.kohsuke.args4j.*;

/**
 * @author Thomas Kuntz
 *
 * This class is used with args4j to easily deal with jitsi-hammer arguments
 * and options
 *
 */
public class CmdLineArguments
{
    /**
     * @Option is used by args4j to know what options can be set as arguments
     * for this program.
     */

    @Option(name="-h", aliases= { "--help", "-help" }, usage="Get help and usage"
        + " to run the program")
    private boolean help = false;

    /**
     * The domain name of the XMPP server.
     */
    @Option(name="-XMPPdomain",usage="The XMPP domain name",required=true)
    private String XMPPdomain;

    /**
     * The hostname used to access the XMPP server.
     */
    @Option(name="-XMPPhost",usage="The XMPP server hostname",required=true)
    private String XMPPhost;


    /**
     * The hostname used by the XMPP server (used to access to the MUC).
     */
    @Option(name="-MUCdomain",usage="The MUC domain name",required=true)
    private String MUCdomain;

    /**
     * The name of the MUC room that we'll use.
     */
    @Option(name="-room",usage="The MUC room name")
    private String roomName = "TestHammer";

    /**
     * The port used by the XMPP server.
     */
    @Option(name="-port",usage="The port of the XMPP server")
    private int port = 5222;

    /**
     * The number of fake users jitsi-hammer will create.
     */
    @Option(name="-users",usage="The number of fake users the hammer will create")
    private int numberOfFakeUsers = 1;

    /**
     * The length of the run (in seconds).
     */
    @Option(name="-length",usage="The length of the run in second "
        + "(If zero or negative, the run will never stop)")
    private int runLength = 0;

    /**
     * The path of an ivf file that will be read for vp8 frame
     */
    @Option(name="-ivf",usage="The path of an ivf file that will"
        + " be read for the video stream")
    private String ivffile = null;

    /**
     * The path of a rtpdump file containing recorded VP8 RTP packets
     * that will be read for the video stream
     */
    @Option(name="-videortpdump",usage="The path of a rtpdump file"
        + " containing recorded VP8 RTP packets"
        + " that will be read for the video stream")
    private String videoRtpdumpFile = null;

    /**
     * The path of a rtpdump file containing recorded Opus RTP packets
     * that will be read for the video stream
     */
    @Option(name="-audiortpdump",usage="The path of a rtpdump file"
        + " containing recorded Opus RTP packets"
        + " that will be read for the audio stream")
    private String audioRtpdumpFile = null;

    /**
     * If this boolean is true, the logging of overall stats is activated
     */
    @Option(name="-overallstats",usage="Enable the logging of the overall stats")
    private boolean overallStats = false;

    /**
     * If this boolean is true, the logging of overall stats is activated
     */
    @Option(name="-allstats",usage="Enable the logging of all the stats"
        + "collected during the run")
    private boolean allStats = false;

    /**
     *
     */
    @Option(name="-statspolling", usage="The time (in seconds) between two"
        + " polling of stats")
    private int statsPolling = 5;

    /**
     * Create a HostInfo from the CLI options
     * @return a HostInfo created from the CLI options
     */
    public HostInfo getHostInfoFromArguments()
    {
        return new HostInfo(XMPPdomain, XMPPhost, port,MUCdomain,roomName);
    }

    /**
     * Get the number of fake users jitsi-hammer will create.
     * @return the number of fake users jitsi-hammer will create.
     */
    public int getNumberOfFakeUsers()
    {
        return numberOfFakeUsers;
    }

    /**
     * Get the length of the run (in seconds).
     * @return the length of the run (in seconds).
     */
    public int getRunLength()
    {
        return runLength;
    }

    /**
     * Get the path of an ivf file that will be read for vp8 frame if it was
     * given as option to the program, or null if not.
     * @return the path of an ivf file that will be read for vp8 frame if it was
     * given as option to the program, or null if not.
     */
    public String getIVFFile()
    {
        return ivffile;
    }

    /**
     * Get The path of a rtpdump file containing recorded VP8 RTP packets
     * that will be read for the video stream if it was
     * given as option to the program, or null if not.
     * @return The path of a rtpdump file containing recorded VP8 RTP packets
     * that will be read for the video stream if it was
     * given as option to the program, or null if not.
     */
    public String getVideoRtpdumpFile()
    {
        return videoRtpdumpFile;
    }

    /**
     * Get The path of a rtpdump file containing recorded Opus RTP packets
     * that will be read for the audio stream if it was
     * given as option to the program, or null if not.
     * @return The path of a rtpdump file containing recorded Opus RTP packets
     * that will be read for the audio stream if it was
     * given as option to the program, or null if not.
     */
    public String getAudioRtpdumpFile()
    {
        return audioRtpdumpFile;
    }

    /**
     * Create an return a <tt>MediaDeviceChooser</tt> based on the options and
     * arguments this <tt>CmdLineArguments</tt> has collected and parsed.
     * @return a <tt>MediaDeviceChooser</tt> based on the options and
     * arguments this <tt>CmdLineArguments</tt> has collected and parsed.
     */
    public MediaDeviceChooser getMediaDeviceChooser()
    {
        return new MediaDeviceChooser(this);
    }

    /**
     * Get the boolean of the help option : if true, the help will be displayed
     * @return the boolean of the help option
     */
    public boolean getHelpOption()
    {
        return help;
    }

    /**
     * Get the boolean of the overallStats option : if true,
     * the overall stats will be saved in file at the end of the run.
     * @return the boolean of the overallStats option
     */
    public boolean getOverallStats()
    {
        return overallStats;
    }

    /**
     * Get the boolean of the allStats option : if true,
     * all the stats collected during the run will be saved in file during the
     * run.
     * @return the boolean of the allStats option
     */
    public boolean getAllStats()
    {
        return allStats;
    }

    /**
     * Get the number of seconds between 2 polling of stats set by the user
     * (or the default if not).
     * @return Get the number of seconds between 2 polling
     *  of stats set by the user
     */
    public int getStatsPolling()
    {
        return statsPolling;
    }
}
